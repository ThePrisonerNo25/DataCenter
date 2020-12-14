# Handler
## 定义
  handler是Android系统提供给我们用来更新UI的一套机制，也是一套消息处理机制，我们可以发送消息，也可以通过它来处理消息。
## Android为什么要设计handler机制？
  最根本的问题是为了解决多线程并发的问题。
  假如允许非UI线程更新UI,在一个Activity中，多个线程同时更新UI线程，则会造成界面更新错乱。如果对多个线程进加锁，性能则会下降。
  因此处于以上的目的，Android提供了Handler机制给我们进行UI跟新。（无需关注多线程的问题，所有跟新UI的操作，都是在主线程的消息队列中进行轮询处理）
## Handler原理
* Handler
  封装了消息的发送（主要包括消息发送给谁），内部会跟Looper进行关联，就是说可以在Handler的内部找到Looper,找到了Looper就是找到了MessageQueue,发送消息就是发送到了MessageQueue.
* Looper
    1. 内部包含一个消息队列——messageQueue,所有的Handler发送的消息都走向这个消息队列
    2. Looper.Looper方法,就是一个死循环，不断的从messageQueue取消息，如有消息就处理消息，没有消息就堵塞。
* MessageQueue
  就是一个消息队列,可以添加消息，并处理消息

  ### 总结
  Handler就是负责发送消息，Looper负责接受Handler发送过来的消息，并且把消息回传给Handler自己，MessageQueue就是一个存储消息的容器。
