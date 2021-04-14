package top.xiongmingcai.ioc.entity;


import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Company {
    private List<String> rooms;
    private Map<String, Calculator> calculatorMap;
    private Properties info;

    public Company() {
    }

    private Company(List<String> rooms, Map<String, Calculator> calculatorMap, Properties info) {
        this.rooms = rooms;
        this.calculatorMap = calculatorMap;
        this.info = info;
    }

    public List<String> getRooms() {
        return rooms;
    }

    public void setRooms(List rooms) {
        this.rooms = rooms;
    }

    public Map<String, Calculator> getCalculatorMap() {
        return calculatorMap;
    }

    public void setCalculatorMap(Map<String, Calculator> calculatorMap) {
        this.calculatorMap = calculatorMap;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }
}
