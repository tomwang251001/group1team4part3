package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.util.stream.Collectors;
import at.ac.fhcampuswien.fhmdb.models.ClickEventHandler;

public class MovieCell extends ListCell<Movie> {
    private final Label title = new Label();
    private final Label detail = new Label();
    private final Label genre = new Label();
    private final Label releaseYear = new Label();
    private final Label rating = new Label();
    private final VBox layout = new VBox(title, detail, genre, releaseYear, rating);

    private final Button watchlistBtn = new Button();

    public MovieCell() {

    }

    @Override
    protected void updateItem(Movie movie, boolean empty) {
        super.updateItem(movie, empty);

        if (empty || movie == null) {
            setGraphic(null);
            setText(null);
        } else {
            this.getStyleClass().add("movie-cell");
            title.setText(movie.getTitle());
            detail.setText(
                    movie.getDescription() != null
                            ? movie.getDescription()
                            : "No description available"
            );

            String genres = movie.getGenres()
                    .stream()
                    .map(Enum::toString)
                    .collect(Collectors.joining(", "));
            genre.setText(genres);


            releaseYear.setText("Release: " + String.valueOf(movie.getReleaseYear()));
            rating.setText("Rating: " + String.valueOf(movie.getRating()));

            watchlistBtn.setText("Watchlist");

            // color scheme
            title.getStyleClass().add("text-yellow");
            detail.getStyleClass().add("text-white");
            genre.getStyleClass().add("text-white");
            genre.setStyle("-fx-font-style: italic");
            releaseYear.getStyleClass().add("text-white");
            rating.getStyleClass().add("text-white");
            watchlistBtn.getStyleClass().add("background-yellow");
            layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));



            // layout
            title.fontProperty().set(title.getFont().font(20));
            detail.setMaxWidth(this.getScene().getWidth() - 30);
            detail.setWrapText(true);
            layout.setPadding(new Insets(10));
            layout.spacingProperty().set(10);
            layout.alignmentProperty().set(javafx.geometry.Pos.CENTER_LEFT);
            setGraphic(layout);
        }


    }
    public MovieCell(ClickEventHandler<MovieCell> addToWatchlistClicked) {
        super();
        watchlistBtn.setOnAction(actionEvent -> {
            addToWatchlistClicked.onClick(this);
        });
    }
}

