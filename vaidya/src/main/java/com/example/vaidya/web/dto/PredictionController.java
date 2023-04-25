package com.example.vaidya.web.dto;

import com.example.vaidya.service.PredictionService;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Arrays;

@Controller
@RequestMapping("/predict")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @GetMapping
    public String dignose()
    {
        return "diagnosis";
    }

    @PostMapping
    public String getPrediction(@RequestParam("symptoms")String[] checkboxValue, Model model) throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException {

        String jsonInputString = "{\"symptoms\":[";
        for (int i = 0; i < checkboxValue.length; i++) {
            if(i != checkboxValue.length - 1)
                jsonInputString = jsonInputString + "\"" + checkboxValue[i] + "\",";
            else
                jsonInputString = jsonInputString + "\"" + checkboxValue[i] + "\"";

        }

        jsonInputString = jsonInputString + "]}";

        System.out.println(jsonInputString);
        String prediction = String.valueOf(predictionService.predict(jsonInputString));
        model.addAttribute("stream", prediction);

        return "prediction";
    }
}
