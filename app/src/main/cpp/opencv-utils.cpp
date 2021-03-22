#include "opencv-utils.h"
#include <opencv2/imgproc.hpp>
#include <opencv2/highgui.hpp>

void myFlip(Mat src) {
    flip(src, src, 0);
}

void myBlur(Mat src, float sigma) {
    GaussianBlur(src, src, Size(), sigma);
}

void myErode(Mat src) {
    int morph_size = 2;
    Mat kernel = getStructuringElement(MORPH_RECT,
                                       Size(2 * morph_size + 1, 2 * morph_size + 1),
                                       Point(morph_size, morph_size));
    erode(src, src, kernel);
}

void myDilate(Mat src) {
    int morph_size = 2;
    Mat kernel = getStructuringElement(MORPH_RECT,
                                       Size(2 * morph_size + 1, 2 * morph_size + 1),
                                       Point(morph_size, morph_size));
    dilate(src, src, kernel);
}

Mat myCanny(Mat src) {
    Mat canny;
    Canny(src, canny, 5, 50);
    return canny;
}