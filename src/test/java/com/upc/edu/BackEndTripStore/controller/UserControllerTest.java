package com.upc.edu.BackEndTripStore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.edu.BackEndTripStore.exception.ValidationException;
import com.upc.edu.BackEndTripStore.model.*;
import com.upc.edu.BackEndTripStore.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.upc.edu.BackEndTripStore.service.UserService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;
@SpringBootTest
class UserControllerTest {


    @Test
    void testValidarExcepcionUsername() {
        var user=new User();
        var userService= new UserService() {
            @Override
            public List<User> getAllUsers() {
                return null;
            }

            @Override
            public User getUserById(int id) {
                return null;
            }

            @Override
            public User createUser(User user) {
                return null;
            }

            @Override
            public User updateUser(int id, User updatedUser) {
                return null;
            }

            @Override
            public void deleteUser(int id) {

            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }
        };
        UserController instancia = new UserController(userService);
        Exception exception = assertThrows(ValidationException.class, () -> {instancia.validateUser(user); });

        String expectedMessage = "Username is required";
        String actualMessage = exception.getMessage();
        user.setUsername("");
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void testValidateNoUsername() {
        var user=new User();
        var userService= new UserService() {
            @Override
            public List<User> getAllUsers() {
                return null;
            }

            @Override
            public User getUserById(int id) {
                return null;
            }

            @Override
            public User createUser(User user) {
                return null;
            }

            @Override
            public User updateUser(int id, User updatedUser) {
                return null;
            }

            @Override
            public void deleteUser(int id) {

            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }
        };
        UserController instancia = new UserController(userService);


        user.setPassword("Haro");
        user.setName("Nicolas");
        user.setPhone("123456789");
        user.setEmail("Nickhardav@gamil.com");
        user.setLastname("Dávila");

         assertThrows(ValidationException.class, () -> {instancia.validateUser(user); });

    }

    @Test
    void testValidateNoPassword() {
        var user=new User();
        var userService= new UserService() {
            @Override
            public List<User> getAllUsers() {
                return null;
            }
            @Override
            public User getUserById(int id) {
                return null;
            }
            @Override
            public User createUser(User user) {
                return null;
            }
            @Override
            public User updateUser(int id, User updatedUser) {
                return null;
            }
            @Override
            public void deleteUser(int id) {
            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }
        };
        UserController instancia = new UserController(userService);

        user.setUsername("Nicolas420");

        user.setName("Nicolas");
        user.setPhone("123456789");
        user.setEmail("Nickhardav@gamil.com");
        user.setLastname("Dávila");

        assertThrows(ValidationException.class, () -> {instancia.validateUser(user); });

    }
    @Test
    void testValidateNoName() {
        var user=new User();
        var userService= new UserService() {
            @Override
            public List<User> getAllUsers() {
                return null;
            }

            @Override
            public User getUserById(int id) {
                return null;
            }

            @Override
            public User createUser(User user) {
                return null;
            }

            @Override
            public User updateUser(int id, User updatedUser) {
                return null;
            }

            @Override
            public void deleteUser(int id) {

            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }
        };
        UserController instancia = new UserController(userService);

        user.setUsername("Nicolas420");
        user.setPassword("Haro");

        user.setPhone("123456789");
        user.setEmail("Nickhardav@gamil.com");
        user.setLastname("Dávila");

        assertThrows(ValidationException.class, () -> {instancia.validateUser(user); });

    }
    @Test
    void testValidateNoPhone() {
        var user=new User();
        var userService= new UserService() {
            @Override
            public List<User> getAllUsers() {
                return null;
            }

            @Override
            public User getUserById(int id) {
                return null;
            }

            @Override
            public User createUser(User user) {
                return null;
            }

            @Override
            public User updateUser(int id, User updatedUser) {
                return null;
            }

            @Override
            public void deleteUser(int id) {

            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }
        };
        UserController instancia = new UserController(userService);

        user.setUsername("Nicolas420");
        user.setPassword("Haro");
        user.setName("Nicolas");

        user.setEmail("Nickhardav@gamil.com");
        user.setLastname("Dávila");

        assertThrows(ValidationException.class, () -> {instancia.validateUser(user); });

    }
    @Test
    void testValidateNoEmail() {
        var user=new User();
        var userService= new UserService() {
            @Override
            public List<User> getAllUsers() {
                return null;
            }

            @Override
            public User getUserById(int id) {
                return null;
            }

            @Override
            public User createUser(User user) {
                return null;
            }



            @Override
            public User updateUser(int id, User updatedUser) {
                return null;
            }

            @Override
            public void deleteUser(int id) {

            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }
        };
        UserController instancia = new UserController(userService);
        user.setUsername("Nicolas420");
        user.setPassword("Haro");
        user.setName("Nicolas");
        user.setPhone("123456789");

        user.setLastname("Dávila");

        assertThrows(ValidationException.class, () -> {instancia.validateUser(user); });

    }
    private ObjectMapper objectMapper = new ObjectMapper();
    private com.upc.edu.BackEndTripStore.service.UserService UserService;
    @Autowired
    private UserService userService;
    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new UserController(UserService)).build();
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userService)).build();
    }

   
    @Test

    void testCreateUser() throws Exception {

        User user = new User();
        user.setUsername("Nicolas420");
        user.setPassword("Haro");
        user.setName("Nicolas");
        user.setPhone("123456789");
        user.setEmail("Nickhardav@gmail.com");
        user.setLastname("Dávila");


        String userJson = objectMapper.writeValueAsString(user);


        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/api/tripstore/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson));


        // Verificar que se devuelve el código de estado 200 (0)
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    void testCreateProduct() throws Exception {

        Product product = new Product();
        product.setProductName("ssss");
        product.setProductDescription("string");
        product.setProductPrice(123.1);
        product.setProductImageUrl("string");
        product.setProductRating(123.1);
        product.setProductCategory("string");


        String productJson = objectMapper.writeValueAsString(product);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/tripstore/v1/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    void testCreateTrip() throws Exception {
        // Crear un objeto de usuario para asociar al trip
        User user = new User();
        user.setUsername("string");
        user.setPassword("string");
        user.setName("string");
        user.setLastname("string");
        user.setEmail("string");
        user.setPhone("string");

        // Crear un objeto de trip para enviar en la solicitud POST
        Trip trip = new Trip();
        trip.setOrigin("string");
        trip.setDestination("string");
        trip.setDate("string");
        trip.setUser(user); // Asociar el usuario al tripS

        // Convertir el objeto de trip a JSON
        String tripJson = objectMapper.writeValueAsString(trip);

        // Enviar una solicitud POST al controlador para crear un trip
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/tripstore/v1/trips")
                .contentType(MediaType.APPLICATION_JSON)
                .content(tripJson));

        // Verificar que se devuelve el código de estado 200 (0)
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    void testValidateNoLastName() {
        var user=new User();
        var userService= new UserService() {
            @Override
            public List<User> getAllUsers() {
                return null;
            }

            @Override
            public User getUserById(int id) {
                return null;
            }

            @Override
            public User createUser(User user) {
                return null;
            }

            @Override
            public User updateUser(int id, User updatedUser) {
                return null;
            }

            @Override
            public void deleteUser(int id) {

            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }
        };
        UserController instancia = new UserController(userService);

        user.setUsername("Nicolas420");
        user.setPassword("Haro");
        user.setName("Nicolas");
        user.setPhone("123456789");
        user.setEmail("Nickhardav@gamil.com");

        assertThrows(ValidationException.class, () -> {instancia.validateUser(user); });

    }

    @Test
    void testValidateUserNameCharactersLimit(){
        var user=new User();
        var userService= new UserService() {
            @Override
            public List<User> getAllUsers() {
                return null;
            }

            @Override
            public User getUserById(int id) {
                return null;
            }

            @Override
            public User createUser(User user) {
                return null;
            }

            @Override
            public User updateUser(int id, User updatedUser) {
                return null;
            }

            @Override
            public void deleteUser(int id) {

            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }
        };
        UserController instancia = new UserController(userService);

        user.setUsername("Nicolastubebesita696942012930123");
        user.setPassword("Haro");
        user.setName("Nicolas");
        user.setPhone("123456789");
        user.setEmail("Nickhardav@gamil.com");
        user.setLastname("Dávila");

        assertThrows(ValidationException.class, () -> {instancia.validateUser(user); });
    }

    @Test
    void testValidatePasswordCharacterLimit(){
        var user=new User();
        var userService= new UserService() {
            @Override
            public List<User> getAllUsers() {
                return null;
            }

            @Override
            public User getUserById(int id) {
                return null;
            }

            @Override
            public User createUser(User user) {
                return null;
            }

            @Override
            public User updateUser(int id, User updatedUser) {
                return null;
            }

            @Override
            public void deleteUser(int id) {

            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }
        };
        UserController instancia = new UserController(userService);

        user.setUsername("Nicolas69");
        user.setPassword("Haro1234567891234567899182481824891");
        user.setName("Nicolas");
        user.setPhone("123456789");
        user.setEmail("Nickhardav@gamil.com");
        user.setLastname("Dávila");

        assertThrows(ValidationException.class, () -> {instancia.validateUser(user); });
    }

    @Test
    void testValidateNameCharacterLimit(){
        var user=new User();
        var userService= new UserService() {
            @Override
            public List<User> getAllUsers() {
                return null;
            }

            @Override
            public User getUserById(int id) {
                return null;
            }

            @Override
            public User createUser(User user) {
                return null;
            }

            @Override
            public User updateUser(int id, User updatedUser) {
                return null;
            }

            @Override
            public void deleteUser(int id) {

            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }
        };
        UserController instancia = new UserController(userService);

        user.setUsername("Nicolas69");
        user.setPassword("Haro");
        user.setName("Nicolas&Luisxsiempre69182831802");
        user.setPhone("123456789");
        user.setEmail("Nickhardav@gamil.com");
        user.setLastname("Dávila");

        assertThrows(ValidationException.class, () -> {instancia.validateUser(user); });
    }

    @Test
    void testValidateLastNameCharacterLimit(){
        var user=new User();
        var userService= new UserService() {
            @Override
            public List<User> getAllUsers() {
                return null;
            }

            @Override
            public User getUserById(int id) {
                return null;
            }

            @Override
            public User createUser(User user) {
                return null;
            }

            @Override
            public User updateUser(int id, User updatedUser) {
                return null;
            }

            @Override
            public void deleteUser(int id) {

            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }
        };
        UserController instancia = new UserController(userService);

        user.setUsername("Nicolas69");
        user.setPassword("Haro");
        user.setName("Nicolas");
        user.setPhone("123456789");
        user.setEmail("Nickhardav@gamil.com");
        user.setLastname("Dávila de las Casas Armadas Gutierrez Perez Rodriguez Hernandez");

        assertThrows(ValidationException.class, () -> {instancia.validateUser(user); });
    }

    @Test
    void testValidateEmailCharacterLimit(){
        var user=new User();
        var userService= new UserService() {
            @Override
            public List<User> getAllUsers() {
                return null;
            }

            @Override
            public User getUserById(int id) {
                return null;
            }

            @Override
            public User createUser(User user) {
                return null;
            }

            @Override
            public User updateUser(int id, User updatedUser) {
                return null;
            }

            @Override
            public void deleteUser(int id) {

            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }
        };
        UserController instancia = new UserController(userService);

        user.setUsername("Nicolas69");
        user.setPassword("Haro");
        user.setName("Nicolas");
        user.setPhone("123456789");
        user.setEmail("Nickhardaviladelascasas192938182491024124124012041024@gamil.com");
        user.setLastname("Dávila");

        assertThrows(ValidationException.class, () -> {instancia.validateUser(user); });
    }

    @Test
    void testValidatePhoneCharacterLimit(){
        var user=new User();
        var userService= new UserService() {
            @Override
            public List<User> getAllUsers() {
                return null;
            }

            @Override
            public User getUserById(int id) {
                return null;
            }

            @Override
            public User createUser(User user) {
                return null;
            }

            @Override
            public User updateUser(int id, User updatedUser) {
                return null;
            }

            @Override
            public void deleteUser(int id) {

            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }
        };
        UserController instancia = new UserController(userService);

        user.setUsername("Nicolas69");
        user.setPassword("Haro");
        user.setName("Nicolas");
        user.setPhone("1234567891299");
        user.setEmail("Nickhardav@gamil.com");
        user.setLastname("Dávila");

        assertThrows(ValidationException.class, () -> {instancia.validateUser(user); });
    }
}