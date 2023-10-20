package com.aciworldwide.services.rest.payments.addenda;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.aciworldwide.uob.api.messages.payments.ach.services.ACHAddendaGenerateRqType;
import com.aciworldwide.uob.api.messages.payments.ach.services.ACHAddendaGenerateRsType;
import com.aciworldwide.uob.api.messages.payments.ach.services.ACHAddendaParseRqType;
import com.aciworldwide.uob.api.messages.payments.ach.services.ACHAddendaParseRsType;
import com.aciworldwide.uob.api.messages.payments.ach.services.ACHAddendaValidateRqType;
import com.aciworldwide.uob.api.messages.payments.ach.services.ACHAddendaValidateRsType;
import com.aciworldwide.uob.api.messages.service.payments.achaddenda.ACHAddendaFault;
import com.aciworldwide.uob.api.messages.service.payments.achaddenda.ACHAddendaPortType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = { "ACH Addenda" })
@Path("/addenda/ach")
public class RestAddendaService {

    private ACHAddendaPortType achAddendaService;

    public void setAchAddendaService(ACHAddendaPortType achAddendaService) {
        this.achAddendaService = achAddendaService;
    }

    @ApiOperation(value = "3333333$333333333333   Parse the given addenda and return back the addenda details.")
    @POST
    @Path("/{sec_code}/parse")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ACHAddendaParseRsType parseStateWiseAddenda(@ApiParam(value = "", required = true, allowableValues = " ") @QueryParam("sec_code") String paymentType, @ApiParam(value = "Null Path param") ACHAddendaParseRqType request) throws ACHAddendaFault {
        request.setPaymentType(paymentType);
        return achAddendaService.parseAddenda(request);
    }

    @ApiOperation(value = "** addenda string using the given addenda details.")
    @POST
    @Path("/{sec_code}/generate")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ACHAddendaGenerateRsType generateAddenda(@ApiParam(value = "*1 description.", required = true, allowableValues = "PPD,CCD,WEB,CTX,TAX,CHILD") @PathParam("sec_code") String paymentType, @ApiParam(value = "Null Path param") ACHAddendaGenerateRqType request) throws ACHAddendaFault {
        request.setPaymentType(paymentType);
        return achAddendaService.generateAddenda(request);
    }

    @ApiOperation(value = "&22222222222222222222Validate addenda for a sec_code")
    @POST
    @Path("/{sec_code}/validator")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ACHAddendaValidateRsType validateAddenda(@ApiParam(value = "Null Path param") ACHAddendaValidateRqType request) throws ACHAddendaFault {
        return achAddendaService.validateAddenda(request);
    }
}
