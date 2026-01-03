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
        if (type == Bulldozer.class) {
            return (List<T>) bulldozerProducer.get();
        }

        if (type == Truck.class) {
            return (List<T>) truckProducer.get();
        }

        if (type == Excavator.class) {
            return (List<T>) excavatorProducer.get();
        }

        return new ArrayList<>();
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
