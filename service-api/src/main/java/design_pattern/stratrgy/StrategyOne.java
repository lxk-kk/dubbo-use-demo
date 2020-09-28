package design_pattern.stratrgy;

public class StrategyOne extends AbstractStrategyService {
    @Override
    protected void handle() {
        System.out.println("execute the first strategy");
    }
}
