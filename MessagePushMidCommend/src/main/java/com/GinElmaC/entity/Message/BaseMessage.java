package com.GinElmaC.entity.Message;

/**
 * 传输消息基础类型
 */
public class BaseMessage {
    //消息的类型
    String MsgType;
    //标识信息，用来标识发送服务器以及目标服务器
    String markFromAndTo;
    //时间戳，用来标识发送的时间戳
    String msgSendTime;
    //序列号
    String serialNumber;
    //目标序列号，当接收的服务器
    String needSerialNumber;
    //负载信息
    String data;
    //检查字段
    String checkpoint;
    //链路日志id
    String logId; //todo 实现长链路追踪
}
