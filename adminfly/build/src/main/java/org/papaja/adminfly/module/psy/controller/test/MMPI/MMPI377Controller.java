package org.papaja.adminfly.module.psy.controller.test.MMPI;

import org.papaja.adminfly.module.psy.database.entity.results.AbstractMMPIResult;
import org.papaja.adminfly.module.psy.database.entity.results.MMPI377Result;
import org.papaja.adminfly.module.psy.tests.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.papaja.adminfly.module.psy.tests.Test.MMPI_377;

@SuppressWarnings({"unused"})
@Controller
@RequestMapping("/MMPI_377")
public class MMPI377Controller extends AbstractMMPIController {

    @Override
    public Test getTest() {
        return MMPI_377;
    }

    @Override
    protected AbstractMMPIResult getResultEntity() {
        return new MMPI377Result();
    }

    @Controller
    @RequestMapping("/shared/MMPI_377")
    public static class Shared extends AbstractMMPIController.MMPIShared {

        @Override
        public Test getTest() {
            return MMPI_377;
        }

    }

}
