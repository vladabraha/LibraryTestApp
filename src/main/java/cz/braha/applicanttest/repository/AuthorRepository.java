package cz.braha.applicanttest.repository;

import cz.braha.applicanttest.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

//    Transaction findById(String id);
//
//    List<Transaction> findAll();
//
//    List<Transaction> findByBookingDateAfter(Date after);
//
//    List<Transaction> findByBookingDateBefore(Date before);
//
//    List<Transaction> findByBookingDateBetween(Date from, Date to);
//
//    List<Transaction> findByDirectionIgnoreCase(String direction);
//
//    List<Transaction> findByTransactionTypeIgnoreCase(String transactionType);
//
//    List<Transaction> findByParentId(String parentId);
//
//    @Modifying(clearAutomatically = true)
//    @Transactional
//    @Query("update transactions t set t.categoryId = ?2 where t.id = ?1")
//    void setCategoryIdForTransactionById(String transactionId, int categoryId);
//
//    @Modifying(clearAutomatically = true)
//    @Transactional
//    @Query("update transactions transaction set transaction.isCategoryManuallyAssigned = TRUE where transaction.id = ?1")
//    void setManuallyUpdateCategoryById(String transactionId);
//
//    @Modifying(clearAutomatically = true)
//    @Transactional
//    @Query("update transactions t set t.originalValue = t.value.amount")
//    void setOriginalValueToValue();
//
//    @Modifying(clearAutomatically = true)
//    @Transactional
//    @Query("update transactions t set t.originalValue = ?2 where t.id = ?1")
//    void setOriginalValueById(String transactionId, BigDecimal originalValue);
//
//    @Modifying(clearAutomatically = true)
//    @Transactional
//    @Query("update transactions t set t.value.amount = ?2 where t.id = ?1")
//    void setValueAmountById(String transactionId, BigDecimal valueAmount);
//
////    @Modifying(clearAutomatically = true)
////    @Transactional
////    @Query("update transactions t set t.categories = ?2 where t.id = ?1")
////    void setCategoriesById(String transactionId, Map<Integer, BigDecimal> categories);
//
//    @Query("SELECT COUNT(id) FROM transactions t WHERE t.id = ?1")
//    int getNumberOfTransactionsById(String transactionId);
}
