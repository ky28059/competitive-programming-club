; Competitive Programming example #1: given list of stock prices each day, find when to buy and sell to get most profit
; uses the easier nested recursion method

(define (cp-example stonks)
  (define (stonks-helper num list)
    (if (empty? list)
        0
        (max (- (car list) num) (stonks-helper num (cdr list)))))
  (if (empty? stonks)
      0
      (max (stonks-helper (car stonks) stonks) (cp-example (cdr stonks)))))

;(trace cp-example)
;(cp-example '(1 2 3 4 5))
;(cp-example '(2 3 5 7 5))


; UC Programming example #1: given list of numbers, split the list into 2 sublists of minimum difference
; uses the easier method of checking each value recursively

(define (uc-example lst)
  (define (uc-helper term nums resultlist)
    (let*
        ((trm (apply + term))
         (nms (apply + nums))
         (diff (abs (- trm nms))))
      (cond {(or (empty? list) (empty? nums)) resultlist}
            {else
             (uc-helper
              (append (list (car nums)) term)
              (cdr nums)
              (cons (list diff (list term nums)) resultlist))})))
  (let*
      ((result (uc-helper (list (car lst)) (cdr lst) '()))
       (diffs (map (lambda (x) (car x)) result))
       (key (apply min diffs)))
    (cdr (assoc key result))))

;(uc-example '(4 1 3 2))
;(uc-example '(1 6 4 2 1))
;(uc-example '(5 5 5 5 5))
