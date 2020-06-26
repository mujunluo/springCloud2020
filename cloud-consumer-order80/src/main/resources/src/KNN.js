/*
* @desc Knn算法
* @param  {Object} current
* @param  {Array} points
* @param  {Number} k
* @param  {Function} c
* @return {Array}
*/
// 函数目的是为了得到最靠近的k个点，还有分类标识
function getKnn(current, points, labelX, labelY, k, c) {
    var dists = [];//存放最接近的
    var classify = [];//分类标识
    points.map(function (item) {
        // 存储分类标识
        if (classify.indexOf(item[labelY]) == -1) classify.push(item[labelY]);
        var result = {};
        result.p = item;
        // console.log(result.p);
        result.d = c(current, item[labelX]);
        dists.push(result);
    });
    dists.sort(function (a, b) {//排序
        return a.d - b.d;
    });
    return { dists: dists.slice(0, k), classify: classify };
}

/*
* @desc 决策
* @param  {Object} current 输入值
* @param  {Object} points 训练样本集
* @param  {Object} labelX 用于分类的输入值
* @param  {Object} labelY 用于分类的输出值
* @param  {Number} k 用于选择最近邻的数目
* @param  {Function} c 自定义比较函数
* @return {Object}
*/
function classify0(current, points, labelX, labelY, k, c) {
    var result = [];
    var knn = getKnn(current, points, labelX, labelY, k, c);
    // 最接近的k个点
    var dists = knn.dists;
    for (var i of knn.classify) {
        // 存储特征种类，并把特征出现的次数置为0
        result.push({
            label: i,
            value: 0
        });
    }
    dists.map(function (item) {
        for (var i of result) {
            //   k个最接近点特征进行统计
            if (i.label === item.p[labelY]) {
                i.value++;
                break;
            }
        }
    });
    result.sort(function (a, b) {
        //  特征弧线次数降序排列
        return b.value - a.value;
    });
    //  算出出现次数最多的特征
    return { result: result[0].label, dists: dists };
}