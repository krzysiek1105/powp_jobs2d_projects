package edu.kis.powp.jobs2d.drivers.macro;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.features.DriverFeature;

import java.util.ArrayList;
import java.util.List;


public class MacroDriver implements Job2dDriver {
    private List<DriverCommand> driverCommandList;
    private Job2dDriver driver;

    public MacroDriver() {
        this.driverCommandList = new ArrayList<>();
    }

    public MacroDriver(List<DriverCommand> driverCommandList) {
        this.driverCommandList = driverCommandList;
    }

    public void setDriver(Job2dDriver driver) {
        this.driver = driver;
    }

    public void clearCommandSet() {
        driverCommandList = new ArrayList<>();
    }

    public List<DriverCommand> getDriverCommandList() {
        return driverCommandList;
    }

    public void setDriverFeatureCurrentDriver() {
        DriverFeature.getDriverManager().setCurrentDriver(driver);
    }

    @Override
    public void setPosition(int x, int y) {
        driverCommandList.add(new SetPositionCommand(x, y));
    }

    @Override
    public void operateTo(int x, int y) {
        driverCommandList.add(new OperateToCommand(x, y));
    }

    @Override
    public String toString() {
        return "MacroDriver";
    }
}
