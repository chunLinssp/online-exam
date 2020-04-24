package com.jomn.web.controller.verification;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.jomn.constant.api.Result;
import com.jomn.constant.api.ResultHandle;
import com.jomn.utlis.ImageUtils;
import com.jomn.utlis.VerificationUtils;
import com.sun.imageio.plugins.common.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/api/code")
public class VerificationController {

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @GetMapping
    @ResponseBody
    public void drawImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        ServletOutputStream out = null;
        String type = request.getParameter("type");
        String capStr = null;
        String code = null;
        BufferedImage bi = null;
        capStr = code = captchaProducer.createText();
        bi = captchaProducer.createImage(capStr);
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, code);
        response.setHeader("Access-Token",session.getId());
        out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        out.flush();
    }

}
