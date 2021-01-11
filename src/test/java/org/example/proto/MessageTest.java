package org.example.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;

public class MessageTest {
    @Test
    public void test() {
        CustomMessagePb.CustomMessage.Builder builder = CustomMessagePb.CustomMessage.newBuilder();
        CustomMessagePb.Data data = CustomMessagePb.Data.newBuilder().setData(1000).build();
        builder.addData(data);
        CustomMessagePb.CustomMessage message = builder.setType("type").setUid("uid").build();
        // 序列化
        ByteString bytes = message.toByteString();
        // 反序列化
        CustomMessagePb.CustomMessage m = null;
        try {
            m = CustomMessagePb.CustomMessage.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.println(m);
    }
}
