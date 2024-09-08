package com.example.uploadfile.controller;

import com.example.uploadfile.model.Product;
import com.example.uploadfile.model.ProductForm;
import com.example.uploadfile.service.IProductService;
import com.example.uploadfile.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    private final IProductService productService = new ProductService();
    @Value("${file-upload}")
    private String TMP_FOLDER;

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

    @PostMapping("save")
    public ModelAndView saveProduct(@ModelAttribute ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();

        File uploadDir = new File(TMP_FOLDER);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        try {
            String fullPath = TMP_FOLDER + File.separator + fileName;
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fullPath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Product product = new Product(productForm.getId(), productForm.getName(), productForm.getDescription(), fileName);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
}
