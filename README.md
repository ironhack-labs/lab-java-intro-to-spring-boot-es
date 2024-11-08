
![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# LAB | Java Introducción a Spring Boot

## Introducción

Acabamos de aprender cómo crear GET, así como cómo manejar parámetros de consulta y variables de ruta en las solicitudes GET, así que practiquemos un poco más.

<br>

## Requisitos

1. Haz un fork de este repositorio.
2. Clona este repositorio.
3. Añade a tu instructor y a los calificadores de la clase como colaboradores de tu repositorio. Si no estás seguro de quiénes son los calificadores de tu clase, pregunta a tu instructor o consulta la presentación del primer día.
4. En el repositorio, crea un proyecto de Java y añade el código para las siguientes tareas.

## Entrega

Una vez que termines la tarea, envía un enlace URL a tu repositorio o tu solicitud de extracción en el campo de abajo.

<br>

## Configuración

Para esta práctica, deberás crear dos tablas de base de datos y añadir algunos datos de muestra. Los datos de la base de datos representan clientes ficticios para un hospital multi-ciudad.

<br>

Employee Table (Tabla de empleados)

| employee_id | department  | name            | status  |
| ----------- | ----------- | --------------- | ------- |
| 356712      | cardiology  | Alonso Flores   | ON_CALL |
| 564134      | immunology  | Sam Ortega      | ON      |
| 761527      | cardiology  | German Ruiz     | OFF     |
| 166552      | pulmonary   | Maria Lin       | ON      |
| 156545      | orthopaedic | Paolo Rodriguez | ON_CALL |
| 172456      | psychiatric | John Paul Armes | OFF     |

<br>

*Ten en cuenta que `admitted_by` es una clave externa a la tabla de empleados.*

<br>

Patient Table (Tabla de pacientes)

| patient_id | name              | date_of_birth | admitted_by |
| ---------- | ----------------- | ------------- | ----------- |
| 1          | Jaime Jordan      | 1984-03-02    | 564134      |
| 2          | Marian Garcia     | 1972-01-12    | 564134      |
| 3          | Julia Dusterdieck | 1954-06-11    | 356712      |
| 4          | Steve McDuck      | 1931-11-10    | 761527      |
| 5          | Marian Garcia     | 1999-02-15    | 172456      |

<br>

## Instrucciones

1. **Obtener todos los médicos** (doctors): Crear una ruta para obtener todos los médicos.
2. **Obtener médico por ID**: Crear una ruta para obtener un médico por `employee_id`.
3. **Obtener médicos por estado** (status): Crear una ruta para obtener médicos por `status`.
4. **Obtener médicos por departamento**: Crear una ruta para obtener médicos por `department`.
5. **Obtener todos los pacientes**: Crear una ruta para obtener todos los pacientes.
6. **Obtener paciente por ID**: Crear una ruta para obtener un paciente por `patient_id`.
7. **Obtener pacientes por rango de fecha de nacimiento**: Crear una ruta para obtener pacientes con fecha de nacimiento dentro de un rango especificado.
8. **Obtener pacientes por departamento del médico que los admitió**: Crear una ruta para obtener pacientes por el departamento en el que se encuentra el médico que los admitió (por ejemplo, obtener todos los pacientes admitidos por un médico en cardiología).
9. **Obtener todos los pacientes con un médico cuyo estado es OFF**: Crear una ruta para obtener todos los pacientes con un médico cuyo `status` sea OFF.

<br>

## FAQs (Preguntas frecuentes)

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">Estoy atascado y no sé cómo resolver el problema o por dónde empezar. ¿Qué debo hacer?</summary>

  <br> <!-- ✅ -->

  Si estás atascado en tu código y no sabes cómo resolver el problema o por dónde empezar, debes dar un paso atrás y tratar de formular una pregunta clara y directa sobre el problema específico que enfrentas. El proceso que seguirás al tratar de definir esta pregunta te ayudará a limitar el problema y a encontrar soluciones potenciales.

  Por ejemplo, ¿estás enfrentando un problema porque no entiendes el concepto o estás recibiendo un mensaje de error que no sabes cómo arreglar? Por lo general, es útil intentar formular el problema de la manera más clara posible, incluyendo cualquier mensaje de error que estés recibiendo. Esto puede ayudarte a comunicar el problema a otras personas y, potencialmente, a obtener ayuda de tus compañeros o recursos en línea.

  Una vez que tengas una comprensión clara del problema, deberías poder comenzar a trabajar hacia la solución.

</details>
  
  <br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Cómo creo un proyecto de Spring boot?</summary>

  <br> <!-- ✅ -->

Spring boot es un framework para crear aplicaciones autónomas y de calidad de producción que son fáciles de lanzar y ejecutar. La mejor manera de crear un proyecto de Spring boot es usar el sitio web Spring Initializer. El sitio web proporciona una manera conveniente de generar una estructura básica de proyecto con todas las dependencias y configuraciones necesarias.

- Paso 1: Ve a [start.spring.io](https://start.spring.io/)
- Paso 2: Elige el tipo de proyecto que desea crear, como Maven o Gradle.
- Paso 3: Selecciona la versión de Spring Boot que deseas utilizar.
- Paso 4: Elige las dependencias que necesitas para tu proyecto. Algunas dependencias comunes incluyen web, jpa y data-jpa.
- Paso 5: Haz clic en el botón "Generar" para descargar los archivos del proyecto.

Como alternativa, puedes usar un Entorno de Desarrollo Integrado (IDE) como Eclipse o IntelliJ IDEA. Estos IDEs tienen complementos para crear proyectos de Spring boot, lo que facilita la configuración del entorno y el inicio de la codificación.

</details>
  
<br>

<br>

<details>    
 <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Qué es JPA y cómo puedo usarlo en Java?</summary>
 
 <!-- ✅ -->    

JPA significa Interfaz de Persistencia Java, que es una especificación Java para acceder, persistir y gestionar datos entre objetos Java y una base de datos relacional. JPA proporciona una interfaz estándar para acceder a bases de datos, reduciendo la necesidad de código personalizado de acceso a datos y permitiendo una gestión eficiente de las conexiones a la base de datos.

Para usar JPA en Java, necesitarás incluir las dependencias necesarias en tu proyecto, como la implementación JPA de Hibernate y crear clases de entidades para representar tus datos. Estas clases de entidades serán anotadas con anotaciones específicas de JPA, como `@Entity` y `@Id`, para indicar la asignación entre la clase Java y la tabla de la base de datos.

Aquí hay un fragmento de código para mostrar cómo crear una clase de entidad JPA en Java:

  ```java
  @Entity
  public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String position;

    // Getters and Setters for the attributes
  }
  ```  

</details>   

<br>


<details>  
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Cuál es el propósito de usar las anotaciones "@Entity", "@Table" y "@Column" en JPA (Java Persistence API)?</summary>  

 <br> <!-- ✅ -->  

Las anotaciones `@Entity`, `@Table` y `@Column` en JPA (Java Persistence API) se utilizan para mapear objetos Java a tablas de bases de datos relacionales.

`@Entity` se utiliza para marcar una clase como una entidad persistente. Esto significa que las instancias de la clase pueden almacenarse en una base de datos.

`@Table` se utiliza para definir el nombre de la tabla de base de datos a la que se asignará la entidad.

`@Column` se utiliza para definir las columnas en la tabla que corresponden a los atributos de la entidad.

Aquí hay un ejemplo de cómo usar estas anotaciones:

  ```java
  @Entity
  @Table(name="employee")
  public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    //getters and setters
  }
  ```

  En este ejemplo, la clase `Employee` se marca como una entidad persistente usando la anotación `@Entity`. El nombre de la tabla de base de datos se define usando la anotación `@Table` como "employee" (empleado). Los atributos `id`, `firstName` y `lastName` se mapean a columnas en la tabla "employee" (empleado) usando la anotación `@Column`.

</details>  

<br>


<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Cuál es el propósito de usar las anotaciones "@RestController", "@GetMapping" y "@ResponseStatus" en Java para construir un servicio web RESTful?</summary>

  <br> <!-- ✅ -->

  La anotación `@RestController` se utiliza en Java para definir una clase como un controlador de servicio web RESTful. Esta anotación permite que la clase maneje solicitudes HTTP y devuelva respuestas HTTP.

  La anotación `@GetMapping` se utiliza para asignar una solicitud HTTP GET específica a un método en una clase de controlador. Esto permite que el método maneje la solicitud y devuelva una respuesta.

  La anotación `@ResponseStatus` se utiliza para establecer el código de estado HTTP para la respuesta devuelta por un método en una clase de controlador.

  Aquí hay un fragmento de código que muestra cómo usar estas anotaciones en Java:

  ```java
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.ResponseStatus;
  import org.springframework.web.bind.annotation.RestController;
  import org.springframework.http.HttpStatus;

  @RestController
  public class ExampleController {

    @GetMapping("/example")
    @ResponseStatus(HttpStatus.OK)
    public String exampleMethod() {
      return "This is a response from a RESTful web service";
    }
  }
  ```

  En este ejemplo, se define la clase `ExampleController` como un controlador de servicio web RESTful utilizando la anotación `@RestController`. El método `exampleMethod` está mapeado a una solicitud HTTP GET específica utilizando la anotación `@GetMapping("/example")` y el código de estado HTTP de la respuesta se establece en `HTTP 200 OK` utilizando la anotación `@ResponseStatus(HttpStatus.OK)`.

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Cuál es el propósito de "@JsonIgnore" en Java y cómo se utiliza?</summary>

  <br> <!-- ✅ -->

  La anotación `@JsonIgnore` se utiliza en Jackson (una biblioteca popular para el procesamiento de JSON) para ignorar una propiedad al serializar o deserializar un objeto de/a JSON. Esto significa que cuando el objeto se convierte a JSON, la propiedad marcada con `@JsonIgnore` no se incluirá en la representación JSON.

  La anotación `@JsonIgnore` se aplica a una propiedad en una clase de Java para ignorarla durante la serialización o deserialización de JSON. Por ejemplo, consideremos una clase llamada Employee con una propiedad llamada "password". Para ignorar la propiedad "password", podemos anotarla con `@JsonIgnore`:

  ```java
  public class Employee {
    private String name;
    private int age;
    @JsonIgnore
    private String password;

    // getters and setters for the properties
  }
  ```

  Cuando esta clase se serialice a JSON, la propiedad "password" no se incluirá en la representación JSON.

</details>

<br>

<details>    
 <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Qué es "JpaRepository" y cómo puedo usarlo en Java?</summary>   
 
 <br> <!-- ✅ -->    
  
  `JpaRepository` es una interfaz de Spring Data que extiende la interfaz `PagingAndSortingRepository`. Proporciona todas las operaciones básicas **CRUD (Create, Read, Update, Delete)** (Crear, Leer, Actualizar, Eliminar) y métodos adicionales para trabajar con **JPA (Java Persistence API)** para interactuar con la base de datos.  
  
  Para usar JpaRepository en su proyecto, siga los siguientes pasos:  
  
  Paso 1: Importa las bibliotecas necesarias  
  
  ```java
  import org.springframework.data.jpa.repository.JpaRepository;
  ```

  Paso 2: Crea una interfaz que extienda `JpaRepository`  
  
  ```java
  public interface MyRepository extends JpaRepository<MyEntity, Long> {

  }
  ```

  **Nota**: En el código anterior, `MyEntity` es la clase de entidad con la que desea interactuar y Long es el tipo de la clave primaria de `MyEntity`.  
    
  Paso 3: Inyecta la interfaz en la clase donde la desees usar.  
  
  ```java
  @Autowired
  private MyRepository myRepository;
  ```

  Paso 4: Ahora puedes usar los métodos proporcionados por `JpaRepository` para interactuar con la base de datos, por ejemplo:  
    
  ```java
  MyEntity myEntity = new MyEntity();
  myRepository.save(myEntity);
  ```

  Con los pasos anteriores, ahora puedes usar `JpaRepository` para interactuar con la base de datos en tu proyecto de Java.  
  
</details>  

<br>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Qué son los métodos de consulta derivados en JPA y cómo los uso en Java?</summary>

  <br> <!-- ✅ -->
  
  Los métodos de consulta derivados en JPA son métodos en un repositorio JPA que son generados automáticamente por el marco de trabajo basados en los nombres de método. Estos métodos permiten a los desarrolladores realizar operaciones comunes en la base de datos, como encontrar entidades basadas en criterios específicos, ordenamiento, paginación y más, sin tener que escribir manualmente la consulta SQL correspondiente.

  Para utilizar los métodos de consulta derivados en Java con JPA, siga estos pasos:

  1. Cree una interfaz de repositorio JPA: Para empezar, cree una interfaz que extienda `JpaRepository` y especifique la clase de entidad y el tipo de datos de clave primaria. Por ejemplo:

    ```java
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.example.domain.User;

    public interface UserRepository extends JpaRepository<User, Long> {
    }
    ```

   2. Define el nombre del método: A continuación, puedes definir el nombre del método en función de la consulta que desees realizar. Existen varias convenciones que sigue JPA para determinar la consulta que se va a ejecutar, como palabras clave como `findBy`, `readBy`, `queryBy`, `countBy` y `deleteBy`, seguidas del nombre de las propiedades de la entidad. Por ejemplo, para encontrar todos los usuarios con un nombre específico, puedes definir el nombre del método de la siguiente manera:

    ```java
    List<User> findByFirstName(String firstName);
    ```

   3. Inyectar el repositorio: Finalmente, puedes inyectar el repositorio en tu clase de servicio o componente y llamar a los métodos para realizar las operaciones de consulta.

    ```java
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsersByFirstName(String firstName) {
      return userRepository.findByFirstName(firstName);
    }
    ```

  **Nota**: La implementación exacta de los métodos de consulta derivados puede variar dependiendo de la implementación de JPA que esté utilizando (por ejemplo, Hibernate, EclipseLink, etc.). Sin embargo, el concepto básico de utilizar nombres de métodos para generar consultas sigue siendo el mismo.

</details>

<br>

 <details>    
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Cómo puedo usar las anotaciones JPA "@OneToOne", "@OneToMany", "@ManyToOne", "@ManyToMany", "@JoinColumn" y "@JoinTable" en Java?</summary>    
    
<br> <!-- ✅ -->    
  La API de Persistencia de Java (JPA) proporciona varias anotaciones para mapear relaciones entre entidades en aplicaciones de Java. Estas anotaciones incluyen:    
    
 1. **@OneToOne**: Esta anotación se utiliza para definir una relación uno a uno entre dos entidades. El siguiente código muestra cómo usar la anotación `@OneToOne`:    
    
   ```java
   @Entity
   public class Employee {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String name;

     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "address_id", referencedColumnName = "id")
     private Address address;

     // Getters and setters ...
   }

   @Entity
   public class Address {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String street;

     private String city;

     // Getters and setters ...
   }
   ```

2. **@OneToMany & @ManyToOne**: Estas anotaciones se utilizan para definir relaciones uno a muchos y muchos a uno entre dos entidades.  
  
El siguiente código muestra cómo usar la anotación `@OneToMany` y la anotación `@ManyToOne`:  
  
   ```java
   @Entity
   public class Department {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String name;

     @OneToMany(mappedBy = "department")
     private List<Employee> employees;

     // Getters and setters ...
   }

   @Entity
   public class Employee {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String name;

     @ManyToOne
     @JoinColumn(name = "department_id", referencedColumnName = "id")
     private Department department;

     // Getters and setters ...
   }
   ```

3. **@ManyToMany & @JoinColumn & @JoinTable**: La anotación `@ManyToMany` se utiliza en Java para definir una relación muchos a muchos entre dos entidades. Esto significa que múltiples instancias de una entidad pueden estar relacionadas con múltiples instancias de otra entidad.  
  
La anotación `@JoinColumn` se utiliza en Java para especificar la columna de clave externa que se utilizará para unir las dos entidades. La columna de clave externa se utiliza para establecer una relación entre las entidades.  
  
La anotación `@JoinTable` se utiliza en Java para definir una tabla de unión para una relación muchos a muchos. La tabla de unión se utiliza para almacenar la información de la relación entre las dos entidades.  
  
El siguiente código muestra cómo usar las anotaciones `@ManyToMany`, `@JoinColumn` y `@JoinTable`:  
  
   ```java
   @Entity
   public class User {

       @ManyToMany
       @JoinTable(name = "user_role",
       joinColumns = @JoinColumn(name = "user_id"),
       inverseJoinColumns = @JoinColumn(name = "role_id"))
       private List<Role> roles;

   }

   @Entity
   public class Role {

       @ManyToMany(mappedBy = "roles")
       private List<User> users;

   }
   ```

</details>  

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">I am unable to push changes to my repository. What should I do?</summary>

  <br> <!-- ✅ -->

  If you are unable to push changes to your repository, here are a few steps that you can follow:

  1. Check your internet connection: Ensure that your internet connection is stable and working.
  1. Verify your repository URL: Make sure that you are using the correct repository URL to push your changes.
  2. Check Git credentials: Ensure that your Git credentials are up-to-date and correct. You can check your credentials using the following command:

  ```bash
  git config --list
  ```

  4. Update your local repository: Before pushing changes, make sure that your local repository is up-to-date with the remote repository. You can update your local repository using the following command:

  ```bash
  git fetch origin
  ```

  5. Check for conflicts: If there are any conflicts between your local repository and the remote repository, resolve them before pushing changes.
  6. Push changes: Once you have resolved any conflicts and updated your local repository, you can try pushing changes again using the following command:

  ```bash
  git push origin <branch_name>
  ```

</details>