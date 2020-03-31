package cn.edu.bupt.task;

import cn.bupt.edu.base.protocol.ProtocolReqMsgProto;
import cn.bupt.edu.server.anotate.TaskMapping;
import cn.bupt.edu.server.task.JsonServerTask;
import com.google.protobuf.ByteString;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@TaskMapping(paths = {"/api/v1/deviceaccess/tenant/devices/tenantId"})
public class JsonTask extends JsonServerTask {

    private JsonTask(ProtocolReqMsgProto.ProtocolReqMsg req, ChannelHandlerContext ctx){
        super(req,ctx);
    }
    public JsonTask(){

    }

    protected Object[] Decoding(ByteString rb, Method m) {
        return super.Decoding(rb, m);
    }

    protected byte[] Encoding(Object obj) {
        return super.Encoding(obj);
    }

}
