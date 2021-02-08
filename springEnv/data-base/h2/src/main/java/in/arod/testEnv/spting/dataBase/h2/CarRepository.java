package in.arod.testEnv.spting.dataBase.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {


}
