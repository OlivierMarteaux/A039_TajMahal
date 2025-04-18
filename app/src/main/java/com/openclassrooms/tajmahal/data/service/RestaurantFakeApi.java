package com.openclassrooms.tajmahal.data.service;

import com.openclassrooms.tajmahal.domain.model.Restaurant;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A mock implementation of the {@link RestaurantApi} for testing and development purposes.
 * <p>
 * This class simulates an API by returning a hard-coded {@link Restaurant} object, eliminating the
 * need for real network or database calls. Such fake or mock implementations are commonly used in
 * unit testing and when prototyping an application.
 * </p>
 * <p>
 * For beginners: In software development, a mock is a simulated version of an external system
 * (like an API). Mocks are used to isolate and test certain parts of the software without
 * depending on external systems. By using a mock, developers can simulate how the real system
 * would behave. In this case, instead of making a real API call to get restaurant details,
 * we are using hardcoded values.
 *
 * <p>
 * This class returns details of a specific restaurant, "Taj Mahal", with pre-defined attributes.
 * </p>
 *
 * @see Restaurant
 * @see RestaurantApi
 */
public class RestaurantFakeApi implements RestaurantApi {

    List<Review> initialReviews = Arrays.asList(
            new Review("Ranjit Singh", "https://xsgames.co/randomusers/assets/avatars/male/71.jpg", "Service très rapide et nourriture délicieuse, nous mangeons ici chaque week-end, c'est très rapide et savoureux. Continuez ainsi!", 2),
            new Review("Martyna Siddeswara", "https://xsgames.co/randomusers/assets/avatars/female/31.jpg", "Un service excellent et des plats incroyablement savoureux. Nous sommes vraiment satisfaits de notre expérience au restaurant.", 4),
            new Review("Komala Alanazi", "https://xsgames.co/randomusers/assets/avatars/male/46.jpg", "La cuisine est délicieuse et le service est également excellent. Le propriétaire est très sympathique et veille toujours à ce que votre repas soit satisfaisant. Cet endroit est un choix sûr!", 5),
            new Review("David John", "https://xsgames.co/randomusers/assets/avatars/male/67.jpg", "Les currys manquaient de diversité de saveurs et semblaient tous à base de tomates. Malgré les évaluations élevées que nous avons vues et nos attentes, nous avons été déçus.", 2),
            new Review("Emilie Hood", "https://xsgames.co/randomusers/assets/avatars/female/20.jpg", "Très bon restaurant Indien ! Je recommande.", 4),
            new Review("Isabella King", "https://randomuser.me/api/portraits/women/61.jpg", "Fantastic vegetarian options!", 5),
            new Review("Jack Lewis", "https://randomuser.me/api/portraits/men/62.jpg", "Best steakhouse in town!", 4),
            new Review("Katherine Moore", "https://randomuser.me/api/portraits/women/63.jpg", "Great coffee and desserts.", 4),
            new Review("Liam Nelson", "https://randomuser.me/api/portraits/men/64.jpg", "Loved the live music!", 5),
            new Review("Mia Owens", "https://randomuser.me/api/portraits/women/65.jpg", "The sushi rolls were fresh and tasty.", 5),
            new Review("Noah Parker", "https://randomuser.me/api/portraits/men/66.jpg", "A bit overpriced but great flavors.", 1),
            new Review("Olivia Quinn", "https://randomuser.me/api/portraits/women/67.jpg", "Amazing cocktails and appetizers!", 5),
            new Review("Paul Roberts", "https://randomuser.me/api/portraits/men/68.jpg", "The ribs were fall-off-the-bone tender.", 5),
            new Review("Quinn Scott", "https://randomuser.me/api/portraits/men/69.jpg", "Authentic Italian experience!", 4),
            new Review("Riley Thompson", "https://randomuser.me/api/portraits/women/70.jpg", "Lovely outdoor seating area.", 4),
            new Review("Sophia Underwood", "https://randomuser.me/api/portraits/women/71.jpg", "One of my favorite brunch spots!", 5),
            new Review("Thomas Vaughn", "https://randomuser.me/api/portraits/men/72.jpg", "Service was quick and efficient.", 4),
            new Review("Uma Walker", "https://randomuser.me/api/portraits/women/73.jpg", "The bread was freshly baked and delicious.", 4),
            new Review("Vincent Xander", "https://randomuser.me/api/portraits/men/74.jpg", "The seafood pasta was incredible!", 5),
            new Review("Willow Young", "https://randomuser.me/api/portraits/women/75.jpg", "Would definitely come back!", 5),
            new Review("Xavier Zimmerman", "https://randomuser.me/api/portraits/men/76.jpg", "The desserts were the highlight!", 5),
            new Review("Yasmine Adams", "https://randomuser.me/api/portraits/women/77.jpg", "The best tacos I’ve ever had!", 5),
            new Review("Zane Brooks", "https://randomuser.me/api/portraits/men/78.jpg", "Perfect portion sizes and great flavors.", 4),
            new Review("Abigail Carter", "https://randomuser.me/api/portraits/women/79.jpg", "Loved the spicy margarita!", 4),
            new Review("Benjamin Davis", "https://randomuser.me/api/portraits/men/80.jpg", "A must-visit spot!", 5),
            new Review("Charlotte Evans", "https://randomuser.me/api/portraits/women/81.jpg", "The pasta sauce was out of this world.", 1),
            new Review("Daniel Foster", "https://randomuser.me/api/portraits/men/82.jpg", "Loved the ambiance and decor.", 4),
            new Review("Eleanor Garcia", "https://randomuser.me/api/portraits/women/83.jpg", "Their homemade gelato was amazing!", 5),
            new Review("Felix Harris", "https://randomuser.me/api/portraits/men/84.jpg", "Amazing selection of craft beers!", 4),
            new Review("Grace Ingram", "https://randomuser.me/api/portraits/women/85.jpg", "I’ll be recommending this to all my friends!", 5),
            new Review("Henry Johnson", "https://randomuser.me/api/portraits/men/86.jpg", "The sushi was a bit dry but overall good.", 3),
            new Review("Isla King", "https://randomuser.me/api/portraits/women/87.jpg", "Loved the modern twist on classic dishes!", 5),
            new Review("Jacob Lewis", "https://randomuser.me/api/portraits/men/88.jpg", "I had the best steak of my life here.", 5),
            new Review("Kayla Moore", "https://randomuser.me/api/portraits/women/89.jpg", "Fantastic brunch spot!", 5),
            new Review("Lucas Nelson", "https://randomuser.me/api/portraits/men/90.jpg", "Great for a quick lunch!", 4),
            new Review("Megan Owens", "https://randomuser.me/api/portraits/women/91.jpg", "The charcuterie board was fantastic!", 1),
            new Review("Nathan Parker", "https://randomuser.me/api/portraits/men/92.jpg", "Fantastic burgers and fries!", 5),
            new Review("Olivia Quinn", "https://randomuser.me/api/portraits/women/93.jpg", "The cocktails were so creative!", 5),
            new Review("Patrick Roberts", "https://randomuser.me/api/portraits/men/94.jpg", "The coffee was a bit weak, but good service.", 3),
            new Review("Quincy Smith", "https://randomuser.me/api/portraits/men/95.jpg", "Loved the food, but the service was slow.", 3),
            new Review("Rebecca Thompson", "https://randomuser.me/api/portraits/women/96.jpg", "Perfect for date night!", 5),
            new Review("Samuel Underwood", "https://randomuser.me/api/portraits/men/97.jpg", "Would come back just for the desserts!", 5),
            new Review("Tessa Vaughn", "https://randomuser.me/api/portraits/women/98.jpg", "Great portions and tasty flavors.", 4),
            new Review("Ulysses Walker", "https://randomuser.me/api/portraits/men/99.jpg", "Authentic flavors and great atmosphere!", 4),
            new Review("Kevin White", "https://randomuser.me/api/portraits/men/10.jpg", "Friendly staff, but the food was just okay.", 3),
            new Review("Lilly Roberts", "https://randomuser.me/api/portraits/women/11.jpg", "The sushi was fresh, but lacked variety.", 3),
            new Review("Michael Clark", "https://randomuser.me/api/portraits/men/12.jpg", "Excellent service and great wine selection.", 1),
            new Review("Natalie Scott", "https://randomuser.me/api/portraits/women/13.jpg", "I enjoyed the cozy atmosphere, but the food wasn’t great.", 3),
            new Review("Oscar Mitchell", "https://randomuser.me/api/portraits/men/14.jpg", "Great burgers, but very greasy.", 4),
            new Review("Penny Evans", "https://randomuser.me/api/portraits/women/15.jpg", "I love their homemade pasta.", 5),
            new Review("Quinn Brown", "https://randomuser.me/api/portraits/men/16.jpg", "It’s a great spot, but could improve on the dessert options.", 3),
            new Review("Rosa Garcia", "https://randomuser.me/api/portraits/women/17.jpg", "Delicious salads and healthy options!", 4),
            new Review("Samuel Harris", "https://randomuser.me/api/portraits/men/18.jpg", "Had an amazing time, the food was flavorful!", 5),
            new Review("Tina Wright", "https://randomuser.me/api/portraits/women/19.jpg", "Disappointed with the service, will not come back.", 2),
            new Review("Umar Bennett", "https://randomuser.me/api/portraits/men/20.jpg", "Loved the grilled fish, definitely recommend it!", 5),
            new Review("Vera Jenkins", "https://randomuser.me/api/portraits/women/21.jpg", "Nice ambiance, but the food took too long to arrive.", 3),
            new Review("Walter Grant", "https://randomuser.me/api/portraits/men/22.jpg", "Perfect for a casual meal with friends.", 4),
            new Review("Xena Roberts", "https://randomuser.me/api/portraits/women/23.jpg", "Great for brunch! Love the waffles.", 5),
            new Review("Yannick Lewis", "https://randomuser.me/api/portraits/men/24.jpg", "The cocktails were too strong, but the appetizers were great.", 3),
            new Review("Zoe Collins", "https://randomuser.me/api/portraits/women/25.jpg", "Absolutely loved the chocolate cake.", 5),
            new Review("Aidan Morris", "https://randomuser.me/api/portraits/men/26.jpg", "The steak was cooked perfectly, but the sides were bland.", 4),
            new Review("Bella Wright", "https://randomuser.me/api/portraits/women/27.jpg", "Had a good experience overall, but could be better.", 3),
            new Review("Chloe Garcia", "https://randomuser.me/api/portraits/women/28.jpg", "Excellent service and fantastic desserts.", 5),
            new Review("Dylan Phillips", "https://randomuser.me/api/portraits/men/29.jpg", "The appetizers were delicious, but the main course wasn’t as great.", 3),
            new Review("Ethan Lewis", "https://randomuser.me/api/portraits/men/30.jpg", "Great place for a date night, lovely food.", 4),
            new Review("Freya Peterson", "https://randomuser.me/api/portraits/women/31.jpg", "Highly recommend the seafood platter!", 5),
            new Review("Gabriel Edwards", "https://randomuser.me/api/portraits/men/32.jpg", "The pizza was undercooked, didn’t enjoy it.", 2),
            new Review("Holly Barnes", "https://randomuser.me/api/portraits/women/33.jpg", "Love the vegetarian options, very fresh.", 5),
            new Review("Isaac Jackson", "https://randomuser.me/api/portraits/men/34.jpg", "Nice experience but overpriced.", 3),
            new Review("Julia Foster", "https://randomuser.me/api/portraits/women/35.jpg", "The pasta was delicious, and the wine was excellent.", 1),
            new Review("Adam Carter", "https://randomuser.me/api/portraits/men/36.jpg", "Loved the cozy atmosphere and great food!", 5),
            new Review("Bianca Ross", "https://randomuser.me/api/portraits/women/37.jpg", "The food was okay, but the service was slow.", 3),
            new Review("Caleb Thompson", "https://randomuser.me/api/portraits/men/38.jpg", "Excellent quality, the burgers were delicious.", 5),
            new Review("Diana Mitchell", "https://randomuser.me/api/portraits/women/39.jpg", "Had a great time, but the dessert was too sweet.", 4),
            new Review("Ethan Rogers", "https://randomuser.me/api/portraits/men/40.jpg", "Love the craft beers and chill vibe!", 5),
            new Review("Fiona Cooper", "https://randomuser.me/api/portraits/women/41.jpg", "The salad was fresh, but the main course was bland.", 3),
            new Review("George Parker", "https://randomuser.me/api/portraits/men/42.jpg", "This place has the best coffee in town!", 5),
            new Review("Hannah Simmons", "https://randomuser.me/api/portraits/women/43.jpg", "The food was a bit greasy, but the service was excellent.", 3),
            new Review("Ian Bennett", "https://randomuser.me/api/portraits/men/44.jpg", "Had a great brunch with some friends. Will return!", 4),
            new Review("Jessica Martin", "https://randomuser.me/api/portraits/women/45.jpg", "Delicious vegan options and friendly staff!", 5),
            new Review("Kurtis Gray", "https://randomuser.me/api/portraits/men/46.jpg", "Good but not exceptional, needs improvement.", 3),
            new Review("Laura Green", "https://randomuser.me/api/portraits/women/47.jpg", "Excellent food quality and great atmosphere.", 5),
            new Review("Matthew Harris", "https://randomuser.me/api/portraits/men/48.jpg", "Great steak but the sides were lacking flavor.", 4),
            new Review("Nina Williams", "https://randomuser.me/api/portraits/women/49.jpg", "Loved the fresh seafood, will come back for sure.", 5),
            new Review("Oliver Scott", "https://randomuser.me/api/portraits/men/50.jpg", "The food was average, but the service was top-notch.", 4),
            new Review("Patricia Foster", "https://randomuser.me/api/portraits/women/51.jpg", "The pasta was perfectly cooked, highly recommend.", 5),
            new Review("Quentin Moore", "https://randomuser.me/api/portraits/men/52.jpg", "The food was good, but the portions were small.", 3),
            new Review("Riley Adams", "https://randomuser.me/api/portraits/men/53.jpg", "The ambiance is perfect for a date night.", 5),
            new Review("Sophia Kelly", "https://randomuser.me/api/portraits/women/54.jpg", "A bit disappointed with the pizza crust.", 1),
            new Review("Tyler Roberts", "https://randomuser.me/api/portraits/men/55.jpg", "Amazing experience, everything was delicious.", 5),
            new Review("Ursula Wright", "https://randomuser.me/api/portraits/women/56.jpg", "Great vegetarian options, highly recommend.", 5),
            new Review("Victor Torres", "https://randomuser.me/api/portraits/men/57.jpg", "Had a good time, but the food was a bit too salty.", 3),
            new Review("Wendy Martinez", "https://randomuser.me/api/portraits/women/58.jpg", "Great food and fantastic customer service.", 5),
            new Review("Xander Hill", "https://randomuser.me/api/portraits/men/59.jpg", "Good food, but the noise level was too high.", 3),
            new Review("Yara Walker", "https://randomuser.me/api/portraits/women/60.jpg", "The desserts were so sweet, I had to take a to-go box.", 4)
    );

    List<Review> reviews = new ArrayList<>(initialReviews);

    /**
     * Retrieves a hard-coded {@link Restaurant} object for the "Taj Mahal".
     * <p>
     * This method simulates an API call by immediately returning a Restaurant object
     * with pre-defined attributes. The object represents the "Taj Mahal" restaurant
     * with specific details.
     * </p>
     *
     * @return The hard-coded {@link Restaurant} object for the "Taj Mahal".
     */
    @Override
    public Restaurant getRestaurant() {
        return new Restaurant("Taj Mahal", "Indien", "11h30 - 14h30・18h30 - 22h00",
                "12 Avenue de la Brique - 75010 Paris", "http://www.tajmahal.fr", "06 12 34 56 78",
                true, true);
    }

    /**
     * Retrieves a hard-coded {@link Review} object for the "Taj Mahal".
     * <p>
     * This method simulates an API call by immediately returning a Review list
     * with pre-defined attributes.
     * </p>
     *
     * @return The hard-coded list {@link Review} for the "Taj Mahal".
     */
    @Override
    public List<Review> getReviews() {
        return reviews;
    }
}
