class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        java.util.Arrays.sort(products);

        List<List<String>> result = new java.util.ArrayList<>();
        int left = 0;
        int right = products.length - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            List<String> currentSuggestions = new java.util.ArrayList<>();
            while (left <= right && (products[left].length() <= i || products[left].charAt(i) != c)) {
                left++;
            }
            while (left <= right && (products[right].length() <= i || products[right].charAt(i) != c)) {
                right--;
            }
            for (int j = left; j <= right && currentSuggestions.size() < 3; j++) {
                currentSuggestions.add(products[j]);
            }
            result.add(currentSuggestions);
        }

        return result;
    }
}