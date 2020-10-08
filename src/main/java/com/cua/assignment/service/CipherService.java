package com.cua.assignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.cua.assignment.util.CipherUtil.*;

@Service
public class CipherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CipherService.class);

    public String encode(String stringToEncode){
        LOGGER.info("Text to be decoded :: {}",stringToEncode);
        String[] tokens = stringToEncode.split(" +");
        List<StringBuilder> cipheredList = Arrays.stream(tokens)
                .map(word ->
                {
                    StringBuilder newString = new StringBuilder();
                    int k = 0;
                    for (int i = 0; i < word.length(); i++) {
                        int val = word.charAt(i);
                        k = word.length() - i;
                        if(val > 96 && val < 123) { //Handling uppercase character
                            encodeSmallCaseConverter(val, k, newString);
                        }
                        else if(val > 64 && val < 91){ //Handling lowercase character
                            encodeUpperCaseConverter(val, k, newString);
                        }
                        else { // Handling special character
                            newString.append((char) val);
                        }
                    }
                    return newString;
                }).collect(Collectors.toList());
        LOGGER.info("Encoded text :: {}",cipheredList.toString());
        return generateResponse(cipheredList);
    }


    public String decode(String stringToDecode){
        LOGGER.info("Text to be decoded :: {}",stringToDecode);
        String[] tokens = stringToDecode.split(" +");
        List<StringBuilder> cipheredList = Arrays.stream(tokens)
                .map(word ->
                {
                    StringBuilder newString = new StringBuilder();
                    int k = 0;
                    for (int i = 0; i < word.length(); i++) {
                        int val = word.charAt(i);
                        k = word.length() - i;
                        if(val > 96 && val < 123) { //Handling lowercase character
                            decodeSmallCaseConverter(val, k, newString);
                        }
                        else if(val > 64 && val < 91){ //Handling uppercase character
                            decodeUpperCaseConverter(val, k, newString);
                        }
                        else { // Handling special character
                            newString.append((char) val);
                        }
                    }
                    return newString;
                }).collect(Collectors.toList());
        LOGGER.info("Encoded text :: {}",cipheredList.toString());
        return generateResponse(cipheredList);
    }

    private String generateResponse(List<StringBuilder> response){
        String finalResponse = String.join(" ",response);
        return finalResponse;
    }
}
