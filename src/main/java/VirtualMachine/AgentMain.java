package VirtualMachine;

import java.lang.instrument.Instrumentation;

public class AgentMain {
    public static void agentmain(String agentArgs, Instrumentation ins) {
        ins.addTransformer(new DefineTransformer(),true);
    }
}