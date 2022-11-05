## NIO
### 1. 背景
从 JDK1.4 开始，Java提供给了一系列改进的输入/输出处理的新功能，这些功能被统称为新IO，新增了许多用于处理输入/输出的类，这些类都被
放在java.nio包以及子包下，并且对原java.io包中的许多类都以NIO为基础进行了改写，新增了满足NIO的功能。

### 2，概述
新IO和传统IO有相同的目的，都是用于输入/输出，但新IO使用了不同的方式来处理输入输出。
新IO采用内存映射文件的方式来处理，将文件或文件的一段区域映射到内存中，这样就可以像访问内存一样
来访问文件了，速度比传统的方式要快得多。

Channel(通道)和Buffer(缓冲区)是新IO的两个核心对象，Channel是对传统的输入输出系统的模拟，
在新IO中都通过通道传输。与传统的InputStream、OutputStream的最大区别在于它提供了一个map()方法，
通过该方法可以直接将“一块数据”映射到内存中。如果说传统的输入输出系统是面向流的处理，则新IO是面向块的处理。

Buffer可以理解为一个容器，本质是一个数组，发送到Channel中的所有对象都必须首先放到Buffer中，而从
Channel中读取的数据也必须先放到Buffer中。

除了Channel和Buffer之外，NIO还提供了用于将Unicode字符串映射成字节序列以及逆映射操作的Charset类，
也提供了用于支持非阻塞式输入输出的Selector类。

### 3. Buffer
除了布尔类型之外，其他的基本数据类型都有对应的Buffer类，如IntBuffer、ByteBuffer、CharBuffer...
allocate(int capacity); // 创建一个容量为capacity的xxxBuffer对象。
在Buffer中有三个重要的概念：容量(capacity)、界限(limit)和位置(position)。   
capacity: 缓冲区的容量表示该Buffer的最大数据容量，即最多可以存储多少数据。
limit: 第一个不应该被读出或写入的缓冲区的位置索引。也就是说，位于limit后的数据既不可被读，也不可以被写。
position: 用于指明下一个可以被读出或写入的缓冲区位置索引。

Buffer中包含两个重要的方法，即flip()和clear(),flip()为从Buffer中取出数据做好准备，
而clear()为再次向Buffer中装入数据做好准备。

除了一些移动position、limit、mark的方法之外，Buffer的所有子类还提供了两个重要方法: put()和get()
方法，用于向Buffer中放入数据和从Buffer中取出数据，在这个过程中，Buffer既支持对单个数据的访问，也支持对批量数据的访问。

当使用put()和get()来访问Buffer中的数据时，分为相对和绝对两种。
1.相对：从Buffer的当前position处开始读取或写入数据，然后将position的值按处理元素的个数增加。
2.绝对：直接根据索引向Buffer中读取或写入数据，使用绝对方式访问Buffer里的数据时，并不会影响position的值。

