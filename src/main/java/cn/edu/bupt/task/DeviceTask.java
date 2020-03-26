package cn.edu.bupt.task;

import cn.bupt.edu.base.protocol.ProtocolReqMsgProto;
import cn.bupt.edu.server.anotate.TaskMapping;
import cn.bupt.edu.server.task.DefaultTaskServer;
import cn.edu.bupt.protobuf.DeviceReqProto;
import cn.edu.bupt.protobuf.DeviceRespProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Scope("prototype")
@TaskMapping(paths = {"/api/v1/deviceaccess/device"})
public class DeviceTask extends DefaultTaskServer {
    private DeviceTask(ProtocolReqMsgProto.ProtocolReqMsg req, ChannelHandlerContext ctx) {
        super(req, ctx);
    }

    public DeviceTask() {
    }

    @Override
    protected Object[] Decoding(ByteString rb, Method m) throws InvalidProtocolBufferException {
        return new Object[]{DeviceReqProto.DeviceReq.parseFrom(rb)};
    }

    @Override
    protected byte[] Encoding(Object o) {
        if (o instanceof DeviceRespProto.DeviceResp) {
            DeviceRespProto.DeviceResp resp = (DeviceRespProto.DeviceResp) o;
            return resp.toByteArray();
        }
        return null;
    }
}
