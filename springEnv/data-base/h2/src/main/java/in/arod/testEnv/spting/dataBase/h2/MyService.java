package in.arod.testEnv.spting.dataBase.h2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class MyService {
    private final CarRepository carRepository;

    @PostConstruct
    public void test(){
        final Car s = new Car();
        s.setMark("AUDI");
        carRepository.save(s);
    }
}
