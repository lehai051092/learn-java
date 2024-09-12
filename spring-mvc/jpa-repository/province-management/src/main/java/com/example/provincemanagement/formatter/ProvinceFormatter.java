package com.example.provincemanagement.formatter;

import com.example.provincemanagement.model.Province;
import com.example.provincemanagement.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Province> {
    private final IProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    @NonNull
    public Province parse(@NonNull String text, @NonNull Locale locale) throws ParseException {
        Optional<Province> provinceOptional = provinceService.findById(Long.parseLong(text));
        assert provinceOptional.orElse(null) != null;
        return provinceOptional.orElse(null);
    }

    @Override
    @NonNull
    public String print(@NonNull Province object, @NonNull Locale locale) {
        return "[" + object.getId() + ", " + object.getName()  + "]";
    }
}
