package ru.vise.rest;

import altr.BackEnd;
import com.google.gson.Gson;

import javax.ws.rs.*;

@Path("/experiment")
public class ViseExperiment {
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    @Path("/run")
    public String getClichedMessage(@QueryParam("formSelect") String formSelect, @QueryParam("test") Integer test, @QueryParam("q") String q,
                                    @QueryParam("capital") Double capital,
                                    @QueryParam("mu") Double mu,
                                    @QueryParam("sigma") Double sigma,
                                    @QueryParam("k") Double k,
                                    @QueryParam("stepNumber") Integer stepNumber,
                                    @QueryParam("iteration") Integer iteration,
                                    @QueryParam("peopleCount") Integer peopleCount,
                                    @QueryParam("majorityThreshold") Double majorityThreshold,
                                    @QueryParam("var") String var,
                                    @QueryParam("distrib") String distrib,
                                    @QueryParam("start") Integer start,
                                    @QueryParam("finish") Integer finish,
                                    @QueryParam("step")Integer step,
                                    @QueryParam("multiple") Double multiple,
                                    @QueryParam("experimentId") String experimentId,
                                    @QueryParam("leftBound") Double leftBound,
                                    @QueryParam("rightBound") Double rightBound) {
        // Return some cliched textual content
        String json;
        if (leftBound != null) {
            json = new Gson().toJson(BackEnd.runExperiment(formSelect, capital, distrib, mu, sigma,
                    k, iteration, stepNumber, peopleCount,
                    majorityThreshold, start, finish, step, var, experimentId, leftBound, rightBound));
            return json;
        } else {
            json = new Gson().toJson(BackEnd.runExperiment(formSelect, capital, distrib, mu, sigma,
                    k, iteration, stepNumber, peopleCount,
                    majorityThreshold, start, finish, step, var, experimentId, 0, 0));
            return json;
        }

//        String json = new Gson().toJson(BackEnd.runSimpleEgo(capital, distrib, mu, sigma,
//                k, iteration, stepNumber, peopleCount,
//                majorityThreshold, start, finish, step, var));

    }
    @GET
    @Path("/percentage")
    public String getPercentage(@QueryParam("experimentId") String experimentId) {
        return Double.toString(BackEnd.getPercentage(experimentId));
    }
}
