package design_pattern.stratrgy;

import java.util.HashMap;

public class StrategyService {
    /**
     * 策略 与 服务的映射
     */
    private static HashMap<String, AbstractStrategyService> strategyMap = new HashMap<>();
    static {
        strategyMap.put("1", new StrategyOne());
        strategyMap.put("2", new StrategyTwo());
        strategyMap.put("none", new StrategyNone());
    }

    /**
     * @param strategy 根据用户指定的策略，执行指定的策略逻辑
     */
    public static void handle(String strategy) {
        if (strategyMap.containsKey(strategy)) {
            strategyMap.get(strategy).handle();
        } else {
            strategyMap.get("none").handle();
        }
    }
}
