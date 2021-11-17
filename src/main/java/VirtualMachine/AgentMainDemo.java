package VirtualMachine;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

public class AgentMainDemo {
    public static void main(String[] args) throws Exception{
        String path = "D:\\Java\\Java内存马\\agent\\out\\artifacts\\VirtualMachine\\VirtualMachine.jar";
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor v:list){
            System.out.println(v.displayName());
            if (v.displayName().contains("VirtualMachine.AgentMainDemo")){
                // 将 jvm 虚拟机的 pid 号传入 attach 来进行远程连接
                VirtualMachine vm = VirtualMachine.attach(v.id());
                // 将我们的 agent.jar 发送给虚拟机
                vm.loadAgent(path);
                vm.detach();
            }
        }
    }
}