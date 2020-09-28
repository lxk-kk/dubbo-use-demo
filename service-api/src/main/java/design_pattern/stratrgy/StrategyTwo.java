package design_pattern.stratrgy;

public class StrategyTwo extends AbstractStrategyService {
    @Override
    protected void handle() {
        System.out.println("execute the second strategy");
    }
}
