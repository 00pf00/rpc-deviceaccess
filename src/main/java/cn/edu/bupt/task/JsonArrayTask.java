package cn.edu.bupt.task;

import cn.bupt.edu.base.protocol.ProtocolReqMsgProto;
import cn.bupt.edu.server.anotate.TaskMapping;
import cn.bupt.edu.server.task.JsonArrayServerTask;
import com.google.protobuf.ByteString;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@TaskMapping(paths = {"/api/v1/deviceaccess/tenant/devices/tenantId", "/api/v1/deviceaccess/data/alllatestdata/deviceId"})
public class JsonArrayTask extends JsonArrayServerTask {
    private JsonArrayTask(ProtocolReqMsgProto.ProtocolReqMsg req, ChannelHandlerContext ctx) {
        super(req, ctx);
    }

    public JsonArrayTask() {

    }

    protected Object[] Decoding(ByteString rb, Method m) {
        return super.Decoding(rb, m);
    }

    protected byte[] Encoding(Object obj) {
        return super.Encoding(obj);
    }
}
