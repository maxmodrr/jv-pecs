package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl<T extends Machine> implements MachineService<T> {
    private final MachineProducer<Bulldozer> bulldozerProducer = new BulldozerProducer();
    private final MachineProducer<Truck> truckProducer = new TruckProducer();
    private final MachineProducer<Excavator> excavatorProducer = new ExcavatorProducer();

    @Override
    public List<T> getAll(Class<? extends T> type) {
        List<T> result = new ArrayList<>();

        if (type == Bulldozer.class) {
            for (Bulldozer b : bulldozerProducer.get()) {
                result.add((T) b);
            }
        } else if (type == Excavator.class) {
            for (Excavator e : excavatorProducer.get()) {
                result.add((T) e);
            }
        } else if (type == Truck.class) {
            for (Truck t : truckProducer.get()) {
                result.add((T) t);
            }
        }

        return result;
    }
    
    @Override
    public void fill(List<? super T> machines, T value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> list) {
        for (Machine item : list) {
            item.doWork();
        }
    }
}
