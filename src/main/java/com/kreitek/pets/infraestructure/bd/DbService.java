package com.kreitek.pets.infraestructure.bd;

import com.kreitek.pets.Log;
import com.kreitek.pets.domain.Cat;
import com.kreitek.pets.domain.Dog;

import java.util.ArrayList;
import java.util.List;


public class DbService {
    // El volatile lo usamos si queremos al multithreading
    private static volatile DbService instance = null;

    // TODO Logger declaration
    // La lista de gatos y perros es el recurso compartido
    private List<Cat> cats = new ArrayList<>();
    private List<Dog> dogs = new ArrayList<>();

    // El privado del constructor es por la reflexion, que no se puedan saltar
    private DbService() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }

    public static DbService getInstance() {
        // Aquí para que solo haya un thread en ejecución
        if (instance == null) {
            synchronized(DbService.class) {
                if (instance == null) {
                    instance = new DbService();
                }
            }
        }
        return instance;
    }

    public void addNewDog(Dog dog) {
        dogs.add(dog);
        Log.debug("BdService.Dog added");
        // TODO logger.debug("BdService.Dog added");
    }
    public void addNewCat(Cat cat) {
        cats.add(cat);
        Log.debug("BdService.Cat added");
        // TODO logger.debug("BdService.Cat added");
    }

    public List<Cat> getCats() {
        Log.debug("BdService.Get " + cats.size() + " cats");
        // TODO logger.debug("BdService.Get " + cats.size() + " cats);
        return new ArrayList<>(cats);
    }

    public List<Dog> getDogs() {
        Log.debug("BdService.Get " + cats.size() + " dogs");
        // TODO logger.debug("BdService.Get " + cats.size() + " dogs);
        return new ArrayList<>(dogs);
    }
}
