package com.multi.hereevent.review;

import com.multi.hereevent.dto.ReviewDTO;
import com.multi.hereevent.dto.ReviewImgDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewDAO dao;

    @Transactional
    @Override
    public int insertReview(ReviewDTO review, List<ReviewImgDTO> imgList) {
        if(imgList.isEmpty()){
            return dao.insertReview(review);
        }else{
            dao.insertReview(review);
            return dao.insertReviewImg(imgList);
        }
    }

    @Transactional
    @Override
    public int updateReview(ReviewDTO review, List<ReviewImgDTO> imgList) {
        if (imgList.isEmpty()) {
            return dao.updateReview(review);
        } else {
            dao.updateReview(review);
            return dao.insertReviewImgWithReviewNo(review.getReview_no(), imgList);
        }
    }

    @Override
    public int deleteReview(int review_no) {
        return dao.deleteReview(review_no);
    }

    @Override
    public void deleteReviewImg(int review_img_no) {
        dao.deleteReviewImg(review_img_no);
    }

    @Override
    public List<ReviewDTO> selectAll() {
        return dao.selectAll();
    }

    @Transactional
    @Override
    public ReviewDTO selectReviewWithEventImg(int review_no) {
        ReviewDTO review = dao.selectReviewWithEventImg(review_no);
        review.setReview_imgs(dao.selectReviewImgs(review_no));
        return review;
    }

    @Transactional
    @Override
    public List<ReviewDTO> selectReviewByEventNo(int event_no) {
        List<ReviewDTO> reviewList = dao.selectReviewByEventNo(event_no);
        for(ReviewDTO review : reviewList){
            review.setReview_imgs(dao.selectReviewImgs(review.getReview_no()));
        }
        return reviewList;
    }

    @Transactional
    @Override
    public List<ReviewDTO> selectReviewByMemberNo(int member_no) {
        List<ReviewDTO> reviewList = dao.selectReviewByMemberNo(member_no);
        for(ReviewDTO review : reviewList){
            review.setReview_imgs(dao.selectReviewImgs(review.getReview_no()));
        }
        return reviewList;
    }

    @Override
    public List<ReviewImgDTO> selectReviewImgs(int review_no) {
        return dao.selectReviewImgs(review_no);
    }
}
