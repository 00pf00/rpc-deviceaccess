package cn.edu.bupt.task;

import cn.bupt.edu.server.anotate.TaskMapping;
import cn.bupt.edu.server.task.DefaultTaskServer;
import cn.edu.bupt.protobuf.DeviceProto;
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
        return DeviceProto.Device.parseFrom(byteString);
    }

    @Override
    protected byte[] Encoding(Object o) {
        if (o instanceof DeviceProto.Device) {
            DeviceProto.Device resp = (DeviceProto.Device) o;
            return resp.toByteArray();
        }
        return null;
    }
}
