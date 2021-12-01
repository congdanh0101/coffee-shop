<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<section class="contact-section" id="contact">
        <h2>contact</h2>
        <div class="row">
            <div class="col span-1-of-3">
                <ul class="information">
                    <li>
                        <i class="fas fa-map-marker-alt small-icon"></i> Addres: 1 Quang Trung, quận Gò Vấp, TPHCM
                    </li>
                    <li>
                        <i class="fas fa-envelope small-icon"></i> Email: thecoffeshop010101@gmail.com
                    </li>
                    <li>
                        <i class="fas fa-phone small-icon"></i> Điện thoại: (+84)90 289 1404
                    </li>
                </ul>
                <ul class="social-icon">
                    <li><i class="fab fa-twitter-square "></i></li>
                    <li><i class="fab fa-facebook-square "></i></li>
                    <li><i class="fab fa-instagram-square "></i></li>
                    <li><i class="fab fa-google-plus-square "></i></li>
                </ul>
            </div>
            <div class="col span-2-of-3">
                <form action="index.html">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="floatingPassword" placeholder="Your name" required>
                        <label for="floatingPassword">Your name</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" required>
                        <label for="floatingInput">Your email</label>
                    </div>
                    <div class="form-floating">
                        <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 150px" required></textarea>
                        <label for="floatingTextarea2">Your message</label>
                    </div>

                    <input type="submit" class="btn btn-outline-success" value="SEND">
                </form>
            </div>
    </section>