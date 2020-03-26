package cn.edu.bupt.task;

import cn.bupt.edu.server.anotate.TaskMapping;
import cn.bupt.edu.server.task.DefaultTaskServer;
import cn.edu.bupt.protobuf.DeviceReqProto;
import cn.edu.bupt.protobuf.DeviceRespProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@TaskMapping(paths = {"/api/v1/deviceaccess/device"})
public class DeviceTask extends DefaultTaskServer {
    @Override
    protected Object Decoding(ByteString byteString) throws InvalidProtocolBufferException {
        return DeviceReqProto.DeviceReq.parseFrom(byteString);
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
