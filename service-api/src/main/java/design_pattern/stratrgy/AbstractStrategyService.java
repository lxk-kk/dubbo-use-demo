package design_pattern.stratrgy;

/**
 * 抽象策略服务
 */
public abstract class AbstractStrategyService {
    /**
     * 抽象策略方法：子类实现具体的业务逻辑
     */
    abstract protected void handle();
}
