package com.kaveenrodrigo.blog.codegen.sample.api.impl;

import com.kaveenrodrigo.blog.codegen.sample.api.*;
import com.kaveenrodrigo.blog.codegen.sample.models.ErrorModelDTO;
import com.kaveenrodrigo.blog.codegen.sample.models.NewPetDTO;
import com.kaveenrodrigo.blog.codegen.sample.models.PetDTO;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.annotations.Api;

/**
 * Swagger Petstore
 *
 * <p>A sample API that uses a petstore as an example to demonstrate features in the swagger-2.0 specification
 *
 */
public class DefaultApiServiceImpl implements DefaultApi {

    static Map<Long,PetDTO> petMap = new HashMap<>();

    public Response addPet(NewPetDTO pet) {

        long id = (long) (petMap.keySet().size() + 1);
        PetDTO newPet = new PetDTO();
        newPet.setName(pet.getName());
        newPet.setTag(pet.getTag());
        newPet.setId(id);
        petMap.put(id, newPet);

        return Response.ok().build();
    }

    public Response deletePet(Long id) {

        petMap.remove(id);

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response findPetById(Long id) {

        PetDTO pet = petMap.get(id);

        return Response.ok().entity(pet).build();
    }

    public Response findPets(List<String> tags, Integer limit) {

        List<PetDTO> pets = new ArrayList<>(petMap.values());

        return Response.ok().entity(pets).build();
    }

}

