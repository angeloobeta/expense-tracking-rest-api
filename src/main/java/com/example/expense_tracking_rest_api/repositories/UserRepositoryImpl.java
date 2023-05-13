package com.example.expense_tracking_rest_api.repositories;

import com.example.expense_tracking_rest_api.domain.User;
import com.example.expense_tracking_rest_api.exception.ExpenseTrackingAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UserRepositoryImpl implements UserRepository{

    // SQL statements for performing operations
    private static final String SQL_CREATE = "INSERT INTO EXPENSE_TRACKER(USER_ID, FIRST_NAME, LAST_NAME, EMAIL, " +
                                             "PASSWORD) VALUES(NEXTVAL('EXPENSE_TRACKER_USERS_SEQ'), ?, ?, ?, ?)";

    // SQL statement for count by email
    private  static  final String SQL_COUNT_BY_EMAIL = "SELECT COUNT(*) FROM EXPENSE_TRACKER_USERS WHERE EMAIL = ?";

    // SQL statement for find by user_id
    private  static  final String SQL_FIND_BY_USER_ID = "SELECT USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD " +
                                                        "FROM EXPENSE_TRACKER_USERS WHERE USER_ID = ?";

    // SQL statement for find by email
    private static final String SQL_FIND_BY_EMAIL = "SELECT FIRST_NAME, LAST_NAME, PASSWORD, EMAIL, PASSWORD" +
                                                    "FROM EXPENSE_TRACKER_USERS WHERE EMAIL =?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer createUser(String firstName, String lastName, String email, String password) throws ExpenseTrackingAuthException {
        try{
            /*
            * For performing any db operation we use the Update method of JdbcTemplate and the same goes for insert
            * but that doesn't return created object or generated key, for that we need a keyholder
             */
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(connection ->{
                /*
                * The lambda gets a connection object as parameter. Add a prepared statement
                */

                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                // pass a flag to return generated keys, which will populate keyholder object
                ps.setString(1, firstName);
                ps.setString(2,lastName);
                ps.setString(3, email);
                ps.setString(4, password);

                // return prepared-statement from this lambda
                return ps;
                }, keyHolder);
            return  (Integer) keyHolder.getKeys().get("USER_ID");
            /*
            * As we can have composite primary keys, we get a map from which we are getting specific key for UserID
             */

        }catch (Exception e){
            throw new ExpenseTrackingAuthException("Invalid Details. Failed to create account");
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws ExpenseTrackingAuthException {
        try{
            User user = jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL,new Object []{email}, userRowMapper);
            if(!password.equals(user.getPassword()))
                throw new ExpenseTrackingAuthException("Incorrect Username or Password");
                return user;
        }catch (EmptyResultDataAccessException e){
            throw new ExpenseTrackingAuthException("Incorrect Username or Password");
        }
    }

    @Override
    public Integer getCountByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, new Object []{email}, Integer.class);
    }

    @Override
    public User findById(Integer userId) {
        /*
        *pass userId in params array and the result is a set of user row. We use a row mapper for it
         */

        return jdbcTemplate.queryForObject(SQL_FIND_BY_USER_ID, new Object []{userId}, userRowMapper );
    }
    private RowMapper<User> userRowMapper = ((rs, rowNum) -> {
        return  new User(
                rs.getInt("USER_ID"),
                rs.getString("FIRST_NAME"),
                rs.getString("LAST_NAME"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD")
        );
    });
}
