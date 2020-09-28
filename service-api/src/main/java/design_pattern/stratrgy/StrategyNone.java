package design_pattern.stratrgy;

public class StrategyNone extends AbstractStrategyService {
    @Override
    protected void handle() {
        System.out.println("no this strategy");
    }
}
