package lk.ijse.dep.rest.repository;

import lk.ijse.dep.rest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {

    List<Customer> findCustomersByAddressLike(String address);

//    @Query("SELECT c FROM Customer c WHERE c.address LIKE ?1")
//    @Query(value = "SELECT * FROM Customer AS c WHERE c.address LIKE ?#{[0]}",nativeQuery = true)
//    @Query(value = "SELECT * FROM Customer AS c WHERE c.address LIKE :name",nativeQuery = true)
    @Query(value = "SELECT * FROM Customer AS c WHERE c.address LIKE :#{#name}",nativeQuery = true)
//    @Query(value = "SELECT * FROM Customer AS c WHERE c.address LIKE :#{#c.address}",nativeQuery = true)
    List<Customer> someCustomers(@Param("name") String query);
}
