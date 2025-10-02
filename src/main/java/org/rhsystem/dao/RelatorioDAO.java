package org.rhsystem.dao;

import org.rhsystem.model.Cargo;
import org.rhsystem.model.Departamento;

import java.util.HashMap;
import java.util.Map;

public class RelatorioDAO {

    public static int totalUsuariosExistentes(){
        return 0;
    }

    public static int totalCargosExistentes(){
        return 0;
    }

    public static int totalDepartamentosExistentes(){
        return 0;
    }

    public static Map<Departamento, Integer> totalFuncPorDepartamento(){
        return Map<Departamento, Integer> funcPorDepartamento = new HashMap<>();
    }

    public static Map<Cargo, Integer> totalFuncPorCargo(){
        return Map<Cargo, Integer> funcPorCargo = new HashMap<>();
    }

    public static Map<Departamento, Double> mediaSalarialPorDepartamento(){
        return Map<Departamento, Integer> funcPorDepartamento = new HashMap<>();
    }

    public static Map<Cargo, Double> mediaSalarialPorCargo(){
        return Map<Cargo, Integer> funcPorCargo = new HashMap<>();
    }
}
