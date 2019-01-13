package com.kaveenrodrigo.blog.codegen.sample.api;

import com.kaveenrodrigo.blog.codegen.sample.models.ErrorModelDTO;
import com.kaveenrodrigo.blog.codegen.sample.models.NewPetDTO;
import com.kaveenrodrigo.blog.codegen.sample.models.PetDTO;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.jaxrs.PATCH;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Swagger Petstore
 *
 * <p>A sample API that uses a petstore as an example to demonstrate features in the swagger-2.0 specification
 *
 */
@Path("/")
@Api(value = "/", description = "")
public interface DefaultApi  {

    @POST
    @Path("/pets")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "pet response", response = PetDTO.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModelDTO.class) })
    public Response addPet(@Valid NewPetDTO pet);

    @DELETE
    @Path("/pets/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "pet deleted"),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModelDTO.class) })
    public Response deletePet(@PathParam("id") Long id);

    @GET
    @Path("/pets/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml", "text/xml", "text/html" })
    @ApiOperation(value = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "pet response", response = PetDTO.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModelDTO.class) })
    public Response findPetById(@PathParam("id") Long id);

    @GET
    @Path("/pets")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml", "text/xml", "text/html" })
    @ApiOperation(value = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "pet response", response = PetDTO.class, responseContainer = "List"),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModelDTO.class) })
    public Response findPets(@QueryParam("tags") List<String> tags, @QueryParam("limit") Integer limit);
}

