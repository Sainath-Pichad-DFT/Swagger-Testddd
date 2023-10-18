package com.aciworldwide.services.rest.accountaction;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.aciworldwide.uob.api.messages.services.accountaction.AccountActionPortType;
import com.aciworldwide.uob.api.messages.services.accountaction.AccountActionsFault;
import com.aciworldwide.uob.api.messages.services.accountaction.UserActionsFault;
import com.aciworldwide.uob.api.messages.widget.services.GetAccountActionsRqType;
import com.aciworldwide.uob.api.messages.widget.services.GetAccountActionsRsType;
import com.aciworldwide.uob.api.messages.widget.services.GetUserActionsRqType;
import com.aciworldwide.uob.api.messages.widget.services.GetUserActionsRsType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author yadgirs REST implementation For Account Actions Service.
 */
@Api(tags = "Account Action")
@Path("/accountactions")
public class RestAccountActionService {

    private AccountActionPortType service;

    @GET
    @Path("")
    @ApiOperation(value = "Use to retreive the Actions of accounts for account balance widget")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public GetAccountActionsRsType getAccountActions(@ApiParam(value = "Account Identifiers", required = true) @QueryParam("accountIdents") List<String> accountIdents) throws AccountActionsFault {
        GetAccountActionsRqType request = new GetAccountActionsRqType();
        request.getAccounts().addAll(accountIdents);
        return getService().getAccountActions(request);
    }

    @GET
    @Path("/user")
    @ApiOperation(value = "Use to retreive the Actions list of user for account balance widget")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public GetUserActionsRsType getUserActions() throws UserActionsFault {
        GetUserActionsRqType request = new GetUserActionsRqType();
        return getService().getUserActions(request);
    }

    /**
     * @return the service
     */
    public AccountActionPortType getService() {
        return service;
    }

    /**
     * @param service
     *            the service to set
     */
    public void setService(AccountActionPortType service) {
        this.service = service;
    }
}
