package Test;


import java.lang.instrument.Instrumentation;

public class Agent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("agentArgs : " + agentArgs);
        // 注册 DefineTransformer
        inst.addTransformer(new DefineTransformer(), true);
    }
}