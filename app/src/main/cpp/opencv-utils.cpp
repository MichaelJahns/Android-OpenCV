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
    Mat element = getStructuringElement(MORPH_RECT,
                                        Size(2 * morph_size + 1, 2 * morph_size + 1),
                                        Point(morph_size, morph_size));

    erode(src, src, element, Point(-1, -1), 1);
}