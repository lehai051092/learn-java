package com.example.webappmusic.controller;

import com.example.webappmusic.model.Music;
import com.example.webappmusic.model.MusicForm;
import com.example.webappmusic.service.IMusicService;
import com.example.webappmusic.service.MusicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("music")
public class MusicController {
    private final IMusicService musicService = new MusicService();

    @Value("${file-upload}")
    private String TMP_FOLDER;

    @GetMapping("song-list")
    public ModelAndView getSongList() {
        ModelAndView modelAndView = new ModelAndView("templates/song_list");
        modelAndView.addObject("song_list", musicService.getMusics());
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("templates/create");
        modelAndView.addObject("song_form", new MusicForm());
        return modelAndView;
    }

    @PostMapping("save")
    public String save(@ModelAttribute MusicForm musicForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = musicForm.getFile();
        String filename = multipartFile.getOriginalFilename();

        if (filename != null && isAllowedFileType(filename)) {
            File uploadDir = new File(TMP_FOLDER);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {
                String fullPath = TMP_FOLDER + filename;
                FileCopyUtils.copy(musicForm.getFile().getBytes(), new File(fullPath));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            Music music = new Music(musicForm.getId(), musicForm.getName(), musicForm.getArtist(), musicForm.getTypes(), "uploads/" + filename);
            musicService.save(music);

            redirectAttributes.addFlashAttribute("success", "Song created successfully!");
            return "redirect:/music/song-list";
        } else {

            redirectAttributes.addFlashAttribute("success", "Chỉ chấp nhận các file có định dạng: .mp3, .wav, .ogg, .m4p!");
            return "redirect:/music/song-list";
        }
    }

    private boolean isAllowedFileType(String fileName) {
        String fileExtension = getFileExtension(fileName);
        return fileExtension.equals("mp3") || fileExtension.equals("wav")
                || fileExtension.equals("ogg") || fileExtension.equals("m4p");
    }

    private String getFileExtension(String fileName) {
        if (fileName == null) {
            return "";
        }
        int lastIndexOfDot = fileName.lastIndexOf('.');
        if (lastIndexOfDot == -1) {
            return "";
        }
        return fileName.substring(lastIndexOfDot + 1).toLowerCase();
    }
}
