package com.jackiewang.collection.queue;

import java.util.concurrent.DelayQueue;

public class DelayQueueLearning {
    DelayQueue<User> dq = new DelayQueue<>();

    //放入队列的元素必须是Delayed的子元素,必须实现getDelay方法和compareTo方法，只有对象到期才能取走,内部有个priorityqueuue，按照过期时间到期来排序
    //应用:
    //淘宝订单，30分钟没有付款就自动取消订单
    //饿了吗，下单成功60s之后给用户发送短信通知
    //关闭空闲链接
    //缓存
    //任务超时处理
    public void login(User user){
        dq.add(user);
        System.out.println(user.getName()+"上线");
    }
    public void logout() {
        System.out.println(dq);
        try{
            User user = (User) dq.take();
            System.out.println(user.getName()+"时间到，下线");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int onlineSize() {
        return dq.size();
    }
    public static void main(String[] args) {
        DelayQueueLearning test = new DelayQueueLearning();
        test.login(new User(1,"张三", System.currentTimeMillis()+5000));
        test.login(new User(2,"李四", System.currentTimeMillis()+2000));
        test.login(new User(2,"王五", System.currentTimeMillis()+10000));
        while(true){
            test.logout();
            if(test.onlineSize() == 0){
                break;
            }
        }
    }
}
